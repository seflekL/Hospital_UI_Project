@smoke
Feature: Bir kullanici olarak hastane hakkinda daha cok görsel bilgiye sahip olmak icin ana sayfada Gallery sayfasinin olmasini istiyorum.

  @regression
  Scenario: : Url dogrulama testi
    Given Kullanıcı "HLurl" sitesine gider

  @regression
  Scenario: HealLife sitesinde Gallery sayfasinin olmasini istiyorum

    When Kullanıcı Header Bölümünden "Gallery" sayfasına gider
    Then Kullanıcı URL'in "gallery" sayfasında olduğunu doğrular
    And Kullanıcı site başlığının "Gallery" olduğunu doğrular
    And Kullanıcı site içerisinde "Gallery" yazısını görebilmelidir
    And Kullanıcı browser kapatır

  @regression
  Scenario:HealLife sitesinin Footer bölümünden Gallery sayfasina erişebilmeliyim

    When Kullanıcı Footer Bölümünden "Gallery" sayfasına gider
    Then Kullanıcı URL'in "gallery" sayfasında olduğunu doğrular
    And Kullanıcı site başlığının "Gallery" olduğunu doğrular
    And Kullanıcı site içerisinde "Gallery" yazısını görebilmelidir
    And Kullanıcı browser kapatır

  @regression
  Scenario: HealLife sitesinde Gallery sayfasinda Resimlerin ve Başlıklarının olmasini istiyorum

    When Kullanıcı Header Bölümünden "Gallery" sayfasına gider
    Then Kullanıcı site içerisinde Resimlerin ve Başlıklarının olmasını istiyorum
    And Kullanıcı Gallery sayfasında "6" adet içerik bulunmalıdır
    And Kullanıcı browser kapatır

  @regression
  Scenario: HealLife sitesinde Gallery sayfasindaki Bölümlerin doğru sayfaya ulmasmasını istiyorum

    When Kullanıcı Header Bölümünden "Gallery" sayfasına gider
    Then Kullanıcı Gallery sayfasının URL, Title ve içeriğinin doğru olduğunu doğrular
    And Kullanıcı browser kapatır
