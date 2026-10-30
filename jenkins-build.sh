#!/bin/bash
# jenkins-build.sh
# Shell script that mirrors what a Jenkins Freestyle project would execute.

set -e

echo "============================================"
echo " Spring Boot CI/CD Demo - Jenkins Build"
echo "============================================"

echo ""
echo "[Step 1] Cleaning and packaging the application..."
mvn clean package

echo ""
echo "[Step 2] Build complete. Artifacts:"
ls -lh target/*.jar

echo ""
echo "============================================"
echo " Build finished successfully!"
echo "============================================"
