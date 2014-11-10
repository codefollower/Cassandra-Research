- 没有CLUSTERING_COLUMN，但是使用COMPACT STORAGE时，必需定义普通列，并且普通列不能使用Collection类型(list、set、map)

- 有CLUSTERING_COLUMN
  - 使用COMPACT STORAGE时，并且只有一个CLUSTERING_COLUMN
    那么不允许普通列中使用Collection类型，这个CLUSTERING_COLUMN即不能是static的，也不能是CounterColumnType