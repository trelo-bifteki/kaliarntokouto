import re
import json

def parse_text_to_json(text_file):
    entries = []
    current_entry = {}

    with open(text_file, 'r', encoding='utf-8') as file:
        for line in file:
            line = line.strip()
            if line:
                # Check if the line contains a keyword
                print(f"line: {line}")
                if re.match(r'^', line):
                    if current_entry:
                        entries.append(current_entry)
                        current_entry = {}

                    keyword = line.split()[0]
                    current_entry['keyword'] = keyword
                    current_entry['definition'] = ' '.join(line.split()[1:])
                    current_entry['related_words'] = []
                    current_entry['references'] = []
                elif line.startswith('('):
                    current_entry['references'].extend(re.findall(r'\((.*?)\)', line))
                elif 'βλ.' in line:
                    current_entry['references'].extend(line.split('βλ. ')[1].split(', '))
                else:
                    current_entry['related_words'].extend(line.split())

    if current_entry:
        entries.append(current_entry)

    return {'entries': entries}

def save_json(data, output_file):
    with open(output_file, 'w', encoding='utf-8') as file:
        json.dump(data, file, ensure_ascii=False, indent=2)

if __name__ == '__main__':
    text_file = 'kaliarnta.txt'  # Replace with the path to your text file
    output_file = 'kaliarnta.json'  # Output JSON file

    parsed_data = parse_text_to_json(text_file)
    save_json(parsed_data, output_file)
    print(f"Conversion completed. JSON data saved to '{output_file}'.")
