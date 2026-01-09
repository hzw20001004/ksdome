public List<SysXcxCityEntity> streamToTree(List<SysXcxCityEntity> treeList, String parentId) {
	return treeList.stream()
			// 过滤父节点
			.filter(parent -> Objects.equals(parent.getParentId(), parentId))
			// 把父节点children递归赋值成为子节点
			.peek(child -> child.setChildren(streamToTree(treeList,child.getId().toString())))
			.collect(Collectors.toList());
}
//带排序
public List<SysXcxCityEntity> streamToTree(List<SysXcxCityEntity> treeList, String parentId) {
	List<SysXcxCityEntity> sortedList = treeList.stream()
			.filter(parent -> Objects.equals(parent.getParentId(), parentId))
			.sorted(Comparator.comparing(SysXcxCityEntity::getSort, Comparator.nullsLast(String::compareTo)))
			.collect(Collectors.toList());
	// 递归处理子节点并设置到children字段
	sortedList.forEach(node ->
			node.setChildren(streamToTree(treeList, node.getId().toString()))
	);
	return sortedList;
}
