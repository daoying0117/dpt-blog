package ink.zyp.server.utils;

/**
 * 文章摘要工具
 * @author chatGPT&daoying
 */
public class SummaryUtil {

    /**
     * 获取文章摘要200字
     * @param article 原文
     * @return String
     */
    public static String getSummary(String article) {
        String[] sentences = article.split("\\。");
        StringBuilder summaryBuilder = new StringBuilder();

        for (String sentence : sentences) {
            if (summaryBuilder.toString().length() > 200) {
                break;
            }
            summaryBuilder.append(sentence.trim()).append(". ");
        }

        String summary = summaryBuilder.toString().trim();
        if (!summary.endsWith("。")) {
            summary += "...";
        }

        return summary;
    }
}
