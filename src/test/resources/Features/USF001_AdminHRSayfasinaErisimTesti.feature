@smoke
Feature: Admin kullanici olarak Insan Kaynaklari(HR) Sayfasindan Personel Bilgilerine Erismek Istiyorum

  @regression

  Scenario: Insan Kaynaklari Sayfasina Erisim

    Given Admin kullanici ana sayfaya gider
    And Gecerli giris bilgileriyle sisteme giris yapar
    When Admin kullanici "Human Resource" Linkine tiklar
    Then Admin Kullanici "Staff Directory" sayfasini goruntuler