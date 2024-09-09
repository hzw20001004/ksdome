部署命令
>后台启动
```sql

-- 使用阿里的镜像源
npm install  --registry=https://registry.npmmirror.com
-- 安装依赖 跳过问题依赖
npm install --legacy-peer-deps
-- 安装yarn
npm install yarn -g

    --清除yarn缓存
    yarn config set ignore-engines true
    
    
如果使用 npm 安装依赖时一直卡在：idealTree:vue: sill idealTree buildDeps
请按照以下步骤：

删除 文件夹中的 .npmrc 文件
在命令提示符里执行 npm cache verify
在命令提示符里执行 npm config set registry https://registry.npmmirror.com 切换淘宝源
之后再次执行 npm install 即可

    
```












