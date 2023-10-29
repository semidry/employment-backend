# 卓越项目后端

## 构建和部署

确保服务器已经安装`docker compose`, 执行:

```sh
docker compose up
```

进行自动化构建和部署, 服务器应当开放`8080`端口.

## API

### /user

#### /user/login

用户登录, 要求发送`post`请求, 例如:

```json
{
  "userId": "mxy123",
  "password": "123456"
}
```

得到的响应:

```json
{
  "success": true,
  "message": "success",
  "data": true
}
```

`data`字段是布尔值, 表示是否**登录**成功, 如果不成功, 失败原因通过`message`字段返回.

#### /user/register

用户注册, 要求发送`post`请求, 例如:

```json
{
  "userId": "mxy123",
  "password": "123456"
}
```
得到的响应:

```json
{
  "success": true,
  "message": "success",
  "data": true
}
```

`data`字段是布尔值, 表示是否**注册**成功, 如果不成功, 失败原因通过`message`字段返回.