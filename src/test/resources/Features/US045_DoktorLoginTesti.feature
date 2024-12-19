@smoke
Feature: Doktor olarak hastane sisteminde  hastalarima ait islemleri yurutebilecegim panele erisebilmek istiyorum.

  @regression
  Scenario: TC01 İlgili Url tıklanınca login sayfasinin acilip test edilmesi
    Given Kullanıcı Heal Life sitesine giriş yapar
    Then Login sayfasinin sag tarafinda Admin Login penceresi görüntülenmeli
    Then Login sayfasinin sol tarafinda Latest New penceresi görüntülenmeli

  @regression
  Scenario: TC02 Doğru bilgiler ile panele giriş testi
    Given Kullanıcı Heal Life sitesine giriş yapar
    Then username bolumune dogru email girilir
    Then password bolumune dogru password girilir
    Then sign in butonuna tiklanir
    And heal life logosu görüntülenir

  @regression
  Scenario:  TC03 Yanlis bilgilerle login olamama testi.
    Given Kullanıcı Heal Life sitesine giriş yapar
    Then username bolumune yanlis data girilir
    Then password bolumune yanlis data girilir
    Then sign in butonuna tiklanir
    And sisteme giris yapilamadigi ve admin penceresinin gorunur oldugu dogrulanir.
  @regression
  Scenario: TC04 Login sayfasinda forgot password linki bulunmasi ve islevselligi testi
    Given Kullanıcı Heal Life sitesine giriş yapar
    Then forgot password linkine tiklanir
    Then email alanina dogru data girilir
    Then submit butonuna tiklanir
    And textbox a girilen mail adresine sifre geldigi ustteki bilgi kutucugu ile dogrulanir
  @regression
  Scenario: TC05 Admin login linkinden login anasayfaya geri dönüş testi
    Given Kullanıcı Heal Life sitesine giriş yapar
    Then forgot password linkine tiklanir
    Then admin login linkine tiklanir
    And admin anasayfasinda oldugu dogrulanir
