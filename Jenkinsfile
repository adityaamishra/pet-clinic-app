pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub-creds')
    }

    stages {
        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }

        stage('Build Jar') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t rootadi/pet-clinic-app:latest .'
            }
        }

        stage('Push to DockerHub') {
            steps {
                // Use the environment variable for credentials and login
                sh '''
                    echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin
                    docker push rootadi/pet-clinic-app:latest
                '''
            }
        }
    }
}
