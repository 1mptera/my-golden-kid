package utils;
import java.util.Random;
public class RandomMenuGenerator {

  public int generateRandomNumber() {
    Random random = new Random();
    int randomIndexNumber = random.nextInt(10);
    return randomIndexNumber;
  }

  public String rice() {
    String[] rices = new String[]{"현미밥", "흰쌀밥", "옥수수밥", "계란볶음밥", "흑미밥", "호박죽", "새우볶음밥", "충무김밥", "곤드레밥", "콩나물밥"};
    String result = rices[generateRandomNumber()];
    return result;
  }

  public String soup() {
    String[] soups = new String[]{"팽이버섯 미소된장국", "어묵무국", "소고기미역국", "안매운육개장", "콩나물국", "들깨미역국", "떡국", "콩가루배추국", "아욱된장국", "닭곰탕"};
    String result = soups[generateRandomNumber()];
    return result;
  }

  public String vegetable() {
    String[] vegetables = new String[]{"미역줄기볶음", "숙주나물무침", "단호박찜", "새우청경채볶음", "백김치", "가지나물", "두부조림", "참나물무침", "얼갈이나물", "깻잎찜"};
    String result = vegetables[generateRandomNumber()];
    return result;
  }

  public String meat() {
    String[] meats = new String[]{"새우완자볼", "갈비찜", "간장찜닭", "연어스테이크", "소고기찹스테이크", "참치샐러드", "훈제오리구이", "데친크래미무침", "돼지고기양파볶음", "소고기장조림"};
    String result = meats[generateRandomNumber()];
    return result;
  }

  public String dessert() {
    String[] desserts = new String[]{"플레인요거트", "요미요미주스", "ABC주스", "방울토마토", "망고", "후레쉬번", "무지개떡", "식혜", "사과", "절편"};
    String result = desserts[generateRandomNumber()];
    return result;
  }
}
