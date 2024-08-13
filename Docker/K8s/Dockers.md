# K8s 集群部署

```yaml

- {name: k8s-master-111, address: 192.168.31.111, internalAddress: 192.168.31.111, port: 22, user: root, password: "root123"}
- {name: k8s-master-112, address: 192.168.31.112, internalAddress: 192.168.31.112, port: 22, user: root, privateKeyPath: "~/.ssh/id_ed25519"}
- {name: k8s-master-113, address: 192.168.31.113, internalAddress: 192.168.31.113, port: 22, user: root, privateKeyPath: "~/.ssh/id_ed25519"}
- {name: k8s-worker-114, address: 192.168.31.114, internalAddress: 192.168.31.114, port: 22, user: root, privateKeyPath: "~/.ssh/id_ed25519"}
- {name: k8s-worker-115, address: 192.168.31.115, internalAddress: 192.168.31.115, port: 22, user: root, privateKeyPath: "~/.ssh/id_ed25519"}
- {name: k8s-worker-116, address: 192.168.31.116, internalAddress: 192.168.31.116, port: 22, user: root, privateKeyPath: "~/.ssh/id_ed25519"}


etcd:
- k8s-master-111
- k8s-master-112
- k8s-master-113
  control-plane:
- k8s-master-111
- k8s-master-112
- k8s-master-113
  worker:
- k8s-worker-114
- k8s-worker-115
- k8s-worker-116
  registry:
- k8s-worker-114

```



