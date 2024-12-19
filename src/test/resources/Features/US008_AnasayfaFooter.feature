@smoke
Feature: US008 Kullanici ana sayfa  alt barı kontrolu

  @regression
  Scenario: TC01 kullanıcı anasayfa alt brdaki butonların yönlendirmelerini kontrol eder.
    Given Url "HLurl" girer
    And Kullanıcı ana sayfaya yönlendirilir
    And Kullanıcı sayfada alt barı kontrol eder
    And Sayfayi Kapatir