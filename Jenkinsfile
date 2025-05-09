
pipeline {
    agent any
    stages {
        stage('Clone Code') {
            steps {
                git 'https://github.com/your-username/pet-clinic-repo.git'
            }
        }
        stage('Build with Maven') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Docker Build & Run') {
            steps {
                script {
                    dockerImage = docker.build("pet-clinic-app")
                    sh 'docker run -d -p 8080:8080 pet-clinic-app'
                }
            }
        }
    }
}
