# K8s 集群部署

```yaml

- {name: k8s-master-201, address: 192.168.31.201, internalAddress: 192.168.31.201, port: 22, user: root, password: "sig123"}
- {name: k8s-master-202, address: 192.168.31.202, internalAddress: 192.168.31.202, port: 22, user: root, privateKeyPath: "~/.ssh/id_ed25519"}
- {name: k8s-master-203, address: 192.168.31.203, internalAddress: 192.168.31.203, port: 22, user: root, privateKeyPath: "~/.ssh/id_ed25519"}
- {name: k8s-node-211, address: 192.168.31.211, internalAddress: 192.168.31.211, port: 22, user: root, privateKeyPath: "~/.ssh/id_ed25519"}
- {name: k8s-node-212, address: 192.168.31.212, internalAddress: 192.168.31.212, port: 22, user: root, privateKeyPath: "~/.ssh/id_ed25519"}
- {name: k8s-node-213, address: 192.168.31.213, internalAddress: 192.168.31.213, port: 22, user: root, privateKeyPath: "~/.ssh/id_ed25519"}


etcd:
- k8s-master-201
- k8s-master-202
- k8s-master-203
  control-plane:
- k8s-master-201
- k8s-master-202
- k8s-master-203
  worker:
- k8s-node-211
- k8s-node-212
- k8s-node-213

```


> node节点8080问题
```text

拷贝文件到子节点
/etc/kubernetes/admin.conf
kubectl get pod -A
echo "export KUBECONFIG=/etc/kubernetes/admin.conf" >>  ~/.bash_profile x
source ~/.bash_profile
验证节点是否加入进去了
kubectl get nodes
```









