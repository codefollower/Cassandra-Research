- RowFilter.Expression.Serializer.deserialize(DataInputPlus, int, CFMetaData)
  把value = CompositeType.extractComponent(composite, 0)改成value = CompositeType.extractComponent(composite, 1)

- org.apache.cassandra.db.lifecycle.LogFile.make(File, int)
  如果没启用assert，是不会调用下面那行assert matcher.matches()的，
  这会导致java.lang.IllegalStateException: No match found

