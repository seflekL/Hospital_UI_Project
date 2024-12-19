@smoke
Feature: Bir yönetici (admin) olarak, hastane isleyisi ve hasta yönetimi ile ilgili islemleri yapabilcegim bir panele giris yapabilmek istiyorum.
  @regression
  Scenario: TC01 Admin Login Page sayfasinin basarii bir sekilde acildigini dogrulama testi
    Given Kullanici Heal Life "HLadminUrl"  girer
    Then Login sayfasinin sag tarafinda Admin Login penceresi görüntülendigini dogrular
    Then Login sayfasinin sol tarafinda Latest New penceresi görüntülendigini dogrular
    And Sayfayi Kapatir

  @regression
  Scenario: TC02 Doğru bilgiler ile admin  panele giriş testi
    Given Kullanici Heal Life "HLadminUrl"  girer
    When User Name Box tiklar
    Then Gecerli User Name "AdminLevent" Girer
    Then Password Box tiklar
    And Gecerli password "adminpass" girer
    And sign in butonuna tiklanir
    And Admin paneline yonlendirildigini dogrular
    Then Sayfayi Kapatir


  @regression
  Scenario:  TC03 Yanlis bilgilerle login olamama testi.
    Given Kullanici Heal Life "HLadminUrl"  girer
    When User Name Box tiklar
    Then Gecerli User Name "johnDoe@fake.com" Girer
    Then Password Box tiklar
    And Gecerli password "Helloworld" girer
    And sign in butonuna tiklanir
    And Admin paneline giris yapilamadigini dogrular
    Then Sayfayi Kapatir

  @regression
  Scenario: TC04 Forgot Password bağlantısının görünürlüğünü ve işlevselliğini doğrulama testi
    Given  Kullanici Heal Life "HLadminUrl"  girer
    Then Forgot Password yazisinin gorunurlugunu dogrular
    Then Forgot Password'a tiklar
    Then Forgot Password sayfasina yonlendirildigini dogrular
    And Sayfayi Kapatir
  @regression
  Scenario: TC05 Sifre sifirlama islevselligi testi
    Given Kullanici Heal Life "HLadminUrl"  girer
    Then Forgot Password'a tiklar
    Then E mail box'ina "kubranur.admin@heallifehospital.com" girer
    And Submit butonuna tıklar
    Then textbox a girilen mail adresine sifre geldigi ustteki bilgi kutucugu ile dogrulanir
    And Sayfayi Kapatir

  @regression
  Scenario: TC06 Admin giriş bağlantısının görünürlüğü ve işlevselliği testi
    Given Kullanici Heal Life "HLadminUrl"  girer
    Then Forgot Password'a tiklar
    Then Admin Login linkinin gorunurlugunu dogrular
    And  admin login linkine tiklanir
    And admin anasayfasinda oldugu dogrulanir
    And  Sayfayi Kapatir
