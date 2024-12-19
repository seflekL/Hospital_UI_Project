@smoke
Feature: Verify footer and social media links functionality

  @regression1
  Scenario:Kullanıcı qa.heallifehospital.com URL'ine ulaşabilmelidir.
    Given Kullanıcı HLurl adresini ziyaret eder
    And Kullanıcı siteye başarıyla erişebildiğini doğrular
    And Kullanıcı ana sayfanın footer bölümüne kaydırır
    And Kullanıcı sosyal medya ikonu Facebook'un görünür olduğunu doğrular

  @regression1
  Scenario:Sosyal medya ikonlarının ilgili hesaplara yönlendirdiğinin doğrulanması testi
    Given Kullanıcı HLurl adresini ziyaret eder
    And Kullanıcı ana sayfanın footer bölümüne kaydırır
    And Facebook ikonuna tıklar
    And Twitter ikonuna tıklar
    And YouTube ikonuna tıklar
    And Google ikonuna tıklar
    And LinkedIn ikonuna tıklar
    And Kullanıcı Instagram ikonuna tıklar
    And Kullanıcı Pinterest ikonuna tıklar



