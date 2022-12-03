#!/usr/bin/env groovy

def call(String imageName) {
    echo "Building the docker image..."

    withCredentials([usernamePassword(credentialsId: 'DockerHub-credential',
    usernameVariable: 'USER', passwordVariable: 'PWD')])
    {
        sh "docker build -t $imageName ."
        sh "echo $PWD | docker login -u $USER --password-stdin"
        sh "docker push $imageName"
    }
}