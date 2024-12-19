@smoke
Feature: Admin kullanici olarak admin panelinde izin taleplerini yonetebilmek istiyorum.
  @regression
  Scenario: Admin kullanici giris bilgileri ile sisteme login olma testi

    Given Admin kullanici giris bilgileri ile sisteme login olur
    And Staff Directory Sayfasina gider
  @regression
  Scenario:Leaves Sayfasindan Approve Leave Request'e Erisilebilmesi
    When Kullanici Leaves butonuna tiklar
    And Kullanici Approve Leave Request butonuna tiklar
    When Kullanici Action basligi altinda Viewe tiklar
    Then Kullanici Details ekraninin goruntulendigini dogrular
  @regression
  Scenario:Approve Leave Request List sayfasindan Add Leave Request penceresine erisilmesi
    When Kullanici Leaves butonuna tiklar
    And Kullanici Approve Leave Request butonuna tiklar
    And Kullanici Add Leave Request butonuna tiklar
    Then Kullanici Add Details ekranina erisir
    When Kullanici Add Details ekraninda formu doldurur
    Then Kullanici kaydedilen izni Approve Leave Request ekraninda goruntuleyebildigini dogrular