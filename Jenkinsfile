pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh './gradlew build'
      }
    }
    stage('containerize') {
      steps {
        sh 'docker build -t kaliarnta/kaliarntokouto:latest .'
      }
    }
  }
}
