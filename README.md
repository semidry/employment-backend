# 卓越项目后端

## 构建

### SpringBoot

对于Linux系统, 在终端执行:

```sh
./gradlew build
```
这会在`build/libs`下生成两个`jar`包, 不带有`plain`的是直接可以部署的`jar`包.

运行`jar`包:

```sh
java -jar [jar-name].jar
```
注意, 项目使用的jdk版本是17, 确保你的jdk版本是17及以上.
