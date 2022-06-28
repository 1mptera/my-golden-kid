package utils;

import java.util.Random;

public class RandomMenuGenerator {

  public int generateRandomNumber() {
    Random random = new Random();
    int randomIndexNumber = random.nextInt(5);
    return randomIndexNumber;
  }

  public String rice() {
    String[] rices = new String[]{"현미밥", "흰쌀밥", "옥수수밥", "계란볶음밥", "흑미밥"};
    String result = rices[generateRandomNumber()];
    return result;
  }

  public String soup() {
    String[] soups = new String[]{"팽이버섯 미소된장국", "어묵무국", "소고기미역국", "안매운육개장", "콩나물국"};
    String result = soups[generateRandomNumber()];
    return result;
  }

  public String vegetable() {
    String[] vegetables = new String[]{"미역줄기볶음", "숙주나물무침", "단호박찜", "새우청경채볶음", "백김치"};
    String result = vegetables[generateRandomNumber()];
    return result;
  }

  public String meat() {
    String[] meats = new String[]{"새우완자볼", "갈비찜", "간장찜닭", "연어스테이크", "소고기찹스테이크"};
    String result = meats[generateRandomNumber()];
    return result;
  }

  public String dessert() {
    String[] desserts = new String[]{"플레인요거트", "요미요미주스", "ABC주스", "방울토마토", "망고"};
    String result = desserts[generateRandomNumber()];
    return result;
  }
}
