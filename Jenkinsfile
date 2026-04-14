pipeline {
    agent any   // Run on any available agent

    tools {
        maven 'Maven'   // Must match name configured in Jenkins (Global Tool Config)
    }

    stages {

        stage('Checkout') {
            steps {
                // Recommended if repo is configured in Jenkins
                checkout scm

                // OR use this if not configured:
                // git url: 'https://github.com/rakshith31-hub/MyMavenSeleniumApp01.git', branch: 'master'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            echo 'Pipeline execution completed'
        }
        success {
            echo 'Build SUCCESS ✅'
        }
        failure {
            echo 'Build FAILED ❌'
        }
    }
}
