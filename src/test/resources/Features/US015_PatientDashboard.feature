@smoke
Feature:Dashboard paneline giris
  @regression1
  Scenario:Login olma Ana sayfadaki giriş işlevine erişmek istiyorum
  Böylece giriş yapıp kontrol paneline ulaşabilirim

    Given kullanici URL'i acar
    And Kullanıcı email adresini girer
    And Gecerli password girer

  @regression1
  Scenario:Geçersiz giriş ve şifremi unuttum işlevi
    Given kullanici URL'i acar
    When password bolumune yanlis data girilir
    And Forgot Password'a tiklar
    And Forgot Password yazisinin gorunurlugunu dogrular
    And email alanina dogru data girilir
    And Submit butonuna tıklar



