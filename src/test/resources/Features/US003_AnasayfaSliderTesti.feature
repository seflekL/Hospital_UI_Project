Feature: Anasayfa Slider Testi

  Background:
    Given Kullanici websitesi URL'ini kullanarak ana sayfaya gider
  @regression1
  Scenario: Ana sayfa kaydırıcısında görsellerin görüntülenmesi ve otomatik değişimi
    When Kullanıcı ana sayfadaki slider'i göruntuler
    And Kullanici ana sayfada slider'da otomatik olarak degisen resimleri goruntuler
  @regression1
  Scenario: Ana sayfa slider'inde gecis ikonu kullanilarak gorseller arasinda gecis yapilmasi
    When Kullanici ana sayfada slider gecis ikonuna tiklar
    And Kullanici bu ikona tiklayarak tum gorselleri manuel olarak degistigini gozlemler
