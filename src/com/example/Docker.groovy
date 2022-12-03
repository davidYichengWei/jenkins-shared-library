#!/usr/bin/env groovy
package com.example

class Docker implements Serializable {
    def script

    Docker(script) {
        this.script = script
    }

    def buildDockerImage(imageName) {
        script.echo "Building the docker image..."

        script.withCredentials([script.usernamePassword(credentialsId: 'DockerHub-credential',
        usernameVariable: 'USER', passwordVariable: 'PWD')])
        {
            script.sh "docker build -t $imageName ."
            script.sh "echo $script.PWD | docker login -u $script.USER --password-stdin"
            script.sh "docker push $imageName"
        }
    }
}