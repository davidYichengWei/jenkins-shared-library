#!/usr/bin/env groovy

import com.example.Docker

def call(String imageName) {
    Docker dockerHelper = new Docker(this)
    dockerHelper.dockerPush(imageName)
}