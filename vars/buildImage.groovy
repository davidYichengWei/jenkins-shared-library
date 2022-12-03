#!/usr/bin/env groovy

def call() {
    echo "Building the docker image..."

    withCredentials([usernamePassword(credentialsId: 'DockerHub-credential',
    usernameVariable: 'USER', passwordVariable: 'PWD')])
    {
        sh "docker build -t yichengwei/demo-jenkins:jma-2.0 ."
        sh "echo $PWD | docker login -u $USER --password-stdin"
        sh "docker push yichengwei/demo-jenkins:jma-2.0"
    }
}