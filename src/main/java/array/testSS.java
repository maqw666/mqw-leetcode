package array;

public class testSS {
    private String tableSchema;

    private String tableName;

    private String enColumnName;

    private String chColumnName;

    private String dataType;

    private String columnDefault;

    private String isNullable;

    private int ifMarkedRed;

    public String getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getEnColumnName() {
        return enColumnName;
    }

    public void setEnColumnName(String enColumnName) {
        this.enColumnName = enColumnName;
    }

    public String getChColumnName() {
        return chColumnName;
    }

    public void setChColumnName(String chColumnName) {
        this.chColumnName = chColumnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getColumnDefault() {
        return columnDefault;
    }

    public void setColumnDefault(String columnDefault) {
        this.columnDefault = columnDefault;
    }

    public String getIsNullable() {
        return isNullable;
    }

    public void setIsNullable(String isNullable) {
        this.isNullable = isNullable;
    }

    public int getIfMarkedRed() {
        return ifMarkedRed;
    }

    public void setIfMarkedRed(int ifMarkedRed) {
        this.ifMarkedRed = ifMarkedRed;
    }

    @Override
    public String toString() {
        return "testSS{" +
                "tableSchema='" + tableSchema + '\'' +
                ", tableName='" + tableName + '\'' +
                ", enColumnName='" + enColumnName + '\'' +
                ", chColumnName='" + chColumnName + '\'' +
                ", dataType='" + dataType + '\'' +
                ", columnDefault='" + columnDefault + '\'' +
                ", isNullable='" + isNullable + '\'' +
                ", ifMarkedRed=" + ifMarkedRed +
                '}';
    }
}
