@smoke

Feature: Pathology Sayfasi Temel Ozellikleri ve Islevselligi

  @regression
  Scenario:Kullanici sisteme giris yapar.
    Given kullanici "HLuserUrl" adresine gider
    And geçerli bir email adresi "LeventPatName" ve sifre "LeventPatPass" girer
    When Sign In butonuna tıklar
    Then dashboard duzgun bir şekilde goruntulenir


