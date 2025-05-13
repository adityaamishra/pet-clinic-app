pipeline {
    agent any

    environment {
        IMAGE_NAME = 'my-java-app'
        DOCKER_REGISTRY = 'your-dockerhub-username'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/your-repo-url.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $DOCKER_REGISTRY/$IMAGE_NAME:latest .'
            }
        }

        stage('Push to Docker Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                    sh 'docker push $DOCKER_REGISTRY/$IMAGE_NAME:latest'
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploy stage (Optional: Add Kubernetes, ECS, etc deployment here)'
            }
        }
    }
}
