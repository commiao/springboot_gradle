# 打包

1. linux环境打包

   ```bash
   $ ./gradlew clean :insurance-app:buildTar -x test  -PprojectEnv=dev
   $ ./gradlew clean :insurance-app-richgo:buildTar -x test  -PprojectEnv=dev
   $ ./gradlew clean :insurance-back:buildTar -x test  -PprojectEnv=dev
   $ ./gradlew clean :insurance-job:buildTar -x test  -PprojectEnv=dev
   ```