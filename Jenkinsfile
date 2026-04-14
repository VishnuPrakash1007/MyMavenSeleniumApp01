pipeline {
    agent any   // Use any available agent

    tools {
        maven 'Maven'   // Make sure this name matches Jenkins config
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'master',
                url: 'https://github.com/VishnuPrakash1007/MyMavenSeleniumApp01.git'
            }
        }
stage('Clean') {
    steps {
        sh 'mvn clean'
    }
}
        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Run Application') {
            steps {
                // Debug: show what is inside target folder
                sh 'ls -l target'

                // Run the generated JAR (auto-detects name)
                sh 'java -jar target/*.jar'
            }
        }
    }

    post {
        success {
            echo 'Build and deployment successful!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
