
# (Done) 테스트 메서드 호출하기
# (Done) 먼저 setUp 호출하기
# (Done) 나중에 tearDown 호출하기
# () 테스트 메서드가 실패하더라도 tearDown 호출하기
# () 여러 개의 테스트 실행하기
# () 수집된 결과를 출력하기
# (Done) WasRun에 로그 문자열 남기기

class TestCase:
    def __init__(self, name):
        self.name = name

    def setUp(self):
        pass

    def run(self):
        self.setUp()
        method= getattr(self, self.name)
        method()
        self.tearDown()

    def tearDown(self):
        pass

class WasRun(TestCase):
    def setUp(self):
        self.wasRun = None
        self.log= "setUp "

    def testMethod(self):
        self.wasRun= 1
        self.log= self.log + "testMethod "

    def tearDown(self):
        self.log= self.log + "tearDown "

class TestCaseTest(TestCase):
    def testTemplateMethod(self):
        test= WasRun("testMethod")
        test.run()
        assert("setUp testMethod tearDown " == test.log)

TestCaseTest("testTemplateMethod").run()


