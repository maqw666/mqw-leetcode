package array;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class test {
    public static void main(String[] args) {

        String testJson = "{\n" +
                "\t\"nodes\":[\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\"position\": {\n" +
                "\t\t\t\t\t\"x\": 220,\n" +
                "\t\t\t\t\t\"y\": 90\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"size\": {\n" +
                "\t\t\t\t\t\"width\": 60,\n" +
                "\t\t\t\t\t\"height\": 60\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"attrs\": {\n" +
                "\t\t\t\t\t\"text\": {\n" +
                "\t\t\t\t\t\t\"text\": \"表输入\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"image\": {\n" +
                "\t\t\t\t\t\t\"xlink:href\": \"data:image/png;base64,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\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"label\": {\n" +
                "\t\t\t\t\t\t\"refX\": 0,\n" +
                "\t\t\t\t\t\t\"refY\": 65,\n" +
                "\t\t\t\t\t\t\"text\": \"表交换输入\"\n" +
                "\t\t\t\t\t}\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"shape\": \"custom-image\",\n" +
                "\t\t\t\t\"ports\": {\n" +
                "\t\t\t\t\t\"groups\": {\n" +
                "\t\t\t\t\t\t\"top\": {\n" +
                "\t\t\t\t\t\t\t\"position\": \"top\",\n" +
                "\t\t\t\t\t\t\t\"attrs\": {\n" +
                "\t\t\t\t\t\t\t\t\"circle\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"r\": 4,\n" +
                "\t\t\t\t\t\t\t\t\t\"magnet\": true,\n" +
                "\t\t\t\t\t\t\t\t\t\"stroke\": \"#5F95FF\",\n" +
                "\t\t\t\t\t\t\t\t\t\"strokeWidth\": 1,\n" +
                "\t\t\t\t\t\t\t\t\t\"fill\": \"#fff\",\n" +
                "\t\t\t\t\t\t\t\t\t\"style\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"visibility\": \"hidden\"\n" +
                "\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"right\": {\n" +
                "\t\t\t\t\t\t\t\"position\": \"right\",\n" +
                "\t\t\t\t\t\t\t\"attrs\": {\n" +
                "\t\t\t\t\t\t\t\t\"circle\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"r\": 4,\n" +
                "\t\t\t\t\t\t\t\t\t\"magnet\": true,\n" +
                "\t\t\t\t\t\t\t\t\t\"stroke\": \"#5F95FF\",\n" +
                "\t\t\t\t\t\t\t\t\t\"strokeWidth\": 1,\n" +
                "\t\t\t\t\t\t\t\t\t\"fill\": \"#fff\",\n" +
                "\t\t\t\t\t\t\t\t\t\"style\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"visibility\": \"hidden\"\n" +
                "\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"bottom\": {\n" +
                "\t\t\t\t\t\t\t\"position\": \"bottom\",\n" +
                "\t\t\t\t\t\t\t\"attrs\": {\n" +
                "\t\t\t\t\t\t\t\t\"circle\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"r\": 4,\n" +
                "\t\t\t\t\t\t\t\t\t\"magnet\": true,\n" +
                "\t\t\t\t\t\t\t\t\t\"stroke\": \"#5F95FF\",\n" +
                "\t\t\t\t\t\t\t\t\t\"strokeWidth\": 1,\n" +
                "\t\t\t\t\t\t\t\t\t\"fill\": \"#fff\",\n" +
                "\t\t\t\t\t\t\t\t\t\"style\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"visibility\": \"hidden\"\n" +
                "\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"left\": {\n" +
                "\t\t\t\t\t\t\t\"position\": \"left\",\n" +
                "\t\t\t\t\t\t\t\"attrs\": {\n" +
                "\t\t\t\t\t\t\t\t\"circle\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"r\": 4,\n" +
                "\t\t\t\t\t\t\t\t\t\"magnet\": true,\n" +
                "\t\t\t\t\t\t\t\t\t\"stroke\": \"#5F95FF\",\n" +
                "\t\t\t\t\t\t\t\t\t\"strokeWidth\": 1,\n" +
                "\t\t\t\t\t\t\t\t\t\"fill\": \"#fff\",\n" +
                "\t\t\t\t\t\t\t\t\t\"style\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"visibility\": \"hidden\"\n" +
                "\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"items\": [{\n" +
                "\t\t\t\t\t\t\"group\": \"left\",\n" +
                "\t\t\t\t\t\t\"id\": \"d7c9b983-9d20-48ea-939f-2c590c02c968\"\n" +
                "\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\"group\": \"right\",\n" +
                "\t\t\t\t\t\t\"id\": \"909dfb07-e101-40ee-b073-9afe6fe00ef8\"\n" +
                "\t\t\t\t\t}]\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"id\": \"13c59f75-dc57-4efb-b775-32f3f1712203\",\n" +
                "\t\t\t\t\"type\": \"table-in\",\n" +
                "\t\t\t\t\"zIndex\": 1\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"position\": {\n" +
                "\t\t\t\t\t\"x\": 220,\n" +
                "\t\t\t\t\t\"y\": 90\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"size\": {\n" +
                "\t\t\t\t\t\"width\": 60,\n" +
                "\t\t\t\t\t\"height\": 60\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"attrs\": {\n" +
                "\t\t\t\t\t\"text\": {\n" +
                "\t\t\t\t\t\t\"text\": \"表输入\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"image\": {\n" +
                "\t\t\t\t\t\t\"xlink:href\": \"data:image/png;base64,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\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"label\": {\n" +
                "\t\t\t\t\t\t\"refX\": 0,\n" +
                "\t\t\t\t\t\t\"refY\": 65,\n" +
                "\t\t\t\t\t\t\"text\": \"表交换输入\"\n" +
                "\t\t\t\t\t}\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"shape\": \"custom-image\",\n" +
                "\t\t\t\t\"ports\": {\n" +
                "\t\t\t\t\t\"groups\": {\n" +
                "\t\t\t\t\t\t\"top\": {\n" +
                "\t\t\t\t\t\t\t\"position\": \"top\",\n" +
                "\t\t\t\t\t\t\t\"attrs\": {\n" +
                "\t\t\t\t\t\t\t\t\"circle\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"r\": 4,\n" +
                "\t\t\t\t\t\t\t\t\t\"magnet\": true,\n" +
                "\t\t\t\t\t\t\t\t\t\"stroke\": \"#5F95FF\",\n" +
                "\t\t\t\t\t\t\t\t\t\"strokeWidth\": 1,\n" +
                "\t\t\t\t\t\t\t\t\t\"fill\": \"#fff\",\n" +
                "\t\t\t\t\t\t\t\t\t\"style\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"visibility\": \"hidden\"\n" +
                "\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"right\": {\n" +
                "\t\t\t\t\t\t\t\"position\": \"right\",\n" +
                "\t\t\t\t\t\t\t\"attrs\": {\n" +
                "\t\t\t\t\t\t\t\t\"circle\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"r\": 4,\n" +
                "\t\t\t\t\t\t\t\t\t\"magnet\": true,\n" +
                "\t\t\t\t\t\t\t\t\t\"stroke\": \"#5F95FF\",\n" +
                "\t\t\t\t\t\t\t\t\t\"strokeWidth\": 1,\n" +
                "\t\t\t\t\t\t\t\t\t\"fill\": \"#fff\",\n" +
                "\t\t\t\t\t\t\t\t\t\"style\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"visibility\": \"hidden\"\n" +
                "\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"bottom\": {\n" +
                "\t\t\t\t\t\t\t\"position\": \"bottom\",\n" +
                "\t\t\t\t\t\t\t\"attrs\": {\n" +
                "\t\t\t\t\t\t\t\t\"circle\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"r\": 4,\n" +
                "\t\t\t\t\t\t\t\t\t\"magnet\": true,\n" +
                "\t\t\t\t\t\t\t\t\t\"stroke\": \"#5F95FF\",\n" +
                "\t\t\t\t\t\t\t\t\t\"strokeWidth\": 1,\n" +
                "\t\t\t\t\t\t\t\t\t\"fill\": \"#fff\",\n" +
                "\t\t\t\t\t\t\t\t\t\"style\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"visibility\": \"hidden\"\n" +
                "\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"left\": {\n" +
                "\t\t\t\t\t\t\t\"position\": \"left\",\n" +
                "\t\t\t\t\t\t\t\"attrs\": {\n" +
                "\t\t\t\t\t\t\t\t\"circle\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"r\": 4,\n" +
                "\t\t\t\t\t\t\t\t\t\"magnet\": true,\n" +
                "\t\t\t\t\t\t\t\t\t\"stroke\": \"#5F95FF\",\n" +
                "\t\t\t\t\t\t\t\t\t\"strokeWidth\": 1,\n" +
                "\t\t\t\t\t\t\t\t\t\"fill\": \"#fff\",\n" +
                "\t\t\t\t\t\t\t\t\t\"style\": {\n" +
                "\t\t\t\t\t\t\t\t\t\t\"visibility\": \"hidden\"\n" +
                "\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"items\": [{\n" +
                "\t\t\t\t\t\t\"group\": \"left\",\n" +
                "\t\t\t\t\t\t\"id\": \"d7c9b983-9d20-48ea-939f-2c590c02c968\"\n" +
                "\t\t\t\t\t}, {\n" +
                "\t\t\t\t\t\t\"group\": \"right\",\n" +
                "\t\t\t\t\t\t\"id\": \"909dfb07-e101-40ee-b073-9afe6fe00ef8\"\n" +
                "\t\t\t\t\t}]\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\"id\": \"13c59f75-dc57-4efb-b775-32f3f1712203\",\n" +
                "\t\t\t\t\"type\": \"table-in\",\n" +
                "\t\t\t\t\"zIndex\": 1\n" +
                "\t\t\t}],\n" +
                "\t\"edges\":[\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\"shape\": \"edge\",\n" +
                "\t\t\t\"attrs\": {\n" +
                "\t\t\t\t\"line\": {\n" +
                "\t\t\t\t\t\"stroke\": \"#A2B1C3\",\n" +
                "\t\t\t\t\t\"targetMarker\": {\n" +
                "\t\t\t\t\t\t\"name\": \"block\",\n" +
                "\t\t\t\t\t\t\"width\": 12,\n" +
                "\t\t\t\t\t\t\"height\": 8\n" +
                "\t\t\t\t\t}\n" +
                "\t\t\t\t} \n" +
                "\t\t\t},\n" +
                "\t\t\t\"id\": \"626cdb0e-c5c9-4a02-981a-51f2314145c8\",\n" +
                "\t\t\t\"zIndex\": 0,\n" +
                "\t\t\t\"source\": {\n" +
                "\t\t\t\t\"cell\": \"c43b80de-e7eb-4fe8-9c97-842b6a2200da\",\n" +
                "\t\t\t\t\"port\": \"6a603a48-928c-4d7b-8964-0fa5ee6b313b\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"target\": {\n" +
                "\t\t\t\t\"cell\": \"10df4377-53a3-4441-b0a0-bdb962d3bd22\",\n" +
                "\t\t\t\t\"port\": \"fc4fbf8e-57a0-4959-b488-8b52532eb364\"\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}\n" +
                "\n" +
                "\n";
        JSONObject jsonObject = JSONObject.fromObject(testJson);
        JSONArray edges = jsonObject.getJSONArray("edges");


        for(int i = 0; i < edges.size(); i++) {
            JSONObject row = edges.getJSONObject(i);
            String sourceWidgetId = row.getJSONObject("source").get("cell").toString();
            String targetWidgetId = row.getJSONObject("target").get("cell").toString();

            System.out.println(sourceWidgetId);
            System.out.println(targetWidgetId);
        }
    }
}
