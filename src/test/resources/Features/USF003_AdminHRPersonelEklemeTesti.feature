@smoke
Feature: Admin kullanici olarak admin panelinde personel ekleme islemlerini yapabilmek istiyorum.

  @regression

  Scenario: Admin kullanici giris bilgileri ile sisteme login olma testi
    Given Admin kullanici giris bilgileri ile sisteme login olur
    And Staff Directory Sayfasina gider
  @regression

  Scenario:Add Staff Sayfasina Erisilebilmesi
    When Kullanici Add Staff butonuna tiklar
    Then Kullanici Basic Information basligi altinda Add Staff Ekranina erisir
  @regression

  Scenario:Staff Kaydi Yapilabilmesi
    When Kullanici Add Staff butonuna tiklar
    And Kullanici kayit formunu doldurur islemi kaydeder
    When Staff Directory Sayfasina gider
    Then Kullanici kaydedilen personelin listede goruntuler
  @regression

  Scenario:Add Staff Sayfasindan Import Staff Sayfasina Erisilebilmesi
    When Kullanici Add Staff butonuna tiklar
    And Kullanici Import Staff butonuna tiklar
    Then Kullanici Import Staff ekranini goruntuler



