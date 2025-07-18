public List<SysXcxCityEntity> streamToTree(List<SysXcxCityEntity> treeList, String parentId) {
	return treeList.stream()
			// 过滤父节点
			.filter(parent -> Objects.equals(parent.getParentId(), parentId))
			// 把父节点children递归赋值成为子节点
			.peek(child -> child.setChildren(streamToTree(treeList,child.getId().toString())))
			.collect(Collectors.toList());
}

