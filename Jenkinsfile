pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
               git branch:'master', url: 'https://github.com/viettrung2103/w6-inclass-docker-jenkin-pipeline.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }
}