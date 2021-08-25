package org.nicoer.bagu;

import org.apache.shardingsphere.sql.parser.SQLParserEngine;
import org.apache.shardingsphere.sql.parser.sql.statement.SQLStatement;
import org.apache.shardingsphere.sql.parser.sql.statement.ddl.CreateTableStatement;

public class Test {
  static String ddl = "";

  public static void main(String[] args) {

    SQLStatement statement = new SQLParserEngine("MySQL").parse(ddl, true);
    if (statement instanceof CreateTableStatement){
      CreateTableStatement createTableStatement = (CreateTableStatement) statement;
      String tableName = createTableStatement.getTable().getTableName().getIdentifier().getValue();
      createTableStatement.getColumnDefinitions().forEach(columnDefinitionSegment -> {
        String columName = columnDefinitionSegment.getColumnName().getQualifiedName();
        String dataTypeName = columnDefinitionSegment.getDataType().getDataTypeName();
        int precision = columnDefinitionSegment.getDataType().getDataLength().getPrecision();
        System.out.println(columName);
      });
      createTableStatement.getConstraintDefinitions();
    }
    System.out.println(statement.getParameterCount());

  }
}
