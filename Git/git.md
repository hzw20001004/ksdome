##Git 日常命令记录

###基础命令
```shell

```

###提交命令
```shell
git  status   状态
git  switch -c dev  创建分支并切换
git checkout -- file 工作区文件回滚
git clone "链接"  从服务器下载git
git add   添加修改的文件到暂存区
git reset --hard HEAD^  回滚到上次pull
git  reset --hard xxxx
git commit -m"xxx"提交到当前分支
git pull  上传到远程库
git pull -u origin   第一次上传
git pull origin dev  上传dev分支到远程库
git remote add origin  关联远程库
git stash  暂存
git stash list 暂存列表
git stash pop 读取并删
git cherry-pick 复制提交
git log 	提交记录
git reflog  操作记录
git branch	 所有分支
git push --set-upstream origin XXX 设置默认分支  
git branch -D <name> 强行删除分支
git reset --soft HEAD^ 不删除工作空间改动代码，撤销commit，不撤销git add . 
git commit --amend 修改注释
```


