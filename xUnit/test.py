
# (Done) 테스트 메서드 호출하기
# (Done) 먼저 setUp 호출하기
# (Done) 나중에 tearDown 호출하기
# () 테스트 메서드가 실패하더라도 tearDown 호출하기
# () 여러 개의 테스트 실행하기
# (Done) 수집된 결과를 출력하기
# (Done) WasRun에 로그 문자열 남기기
# () 실패한 테스트 보고하기

class TestCase:
    def __init__(self, name):
        self.name = name

    def setUp(self):
        pass

    def run(self):
        result= TestResult()
        result.testStarted()
        self.setUp()
        method= getattr(self, self.name)
        method()
        self.tearDown()
        return result

    def tearDown(self):
        pass

class WasRun(TestCase):
    def setUp(self):
        self.wasRun = None
        self.log= "setUp "

    def testMethod(self):
        self.wasRun= 1
        self.log= self.log + "testMethod "

    def testBrokenMethod(self):
        raise Exception

    def tearDown(self):
        self.log= self.log + "tearDown "



class TestResult:
    def __init__(self):
        self.runCount= 0

    def testStarted(self):
        self.runCount= self.runCount + 1

    def summary(self):
        return "%d run, 0 failed" % self.runCount

class TestCaseTest(TestCase):
    def testTemplateMethod(self):
        test= WasRun("testMethod")
        test.run()
        assert("setUp testMethod tearDown " == test.log)

    def testResult(self):
        test= WasRun("testMethod")
        result= test.run()
        assert("1 run, 0 failed" == result.summary())

    def testFailedResult(self):
        test= WasRun("testBrokenMethod")
        result= test.run()
        assert("1 run, 1 failed" == result.summary())


TestCaseTest("testTemplateMethod").run()

TestCaseTest("testResult").run()

TestCaseTest("testFailedResult").run()

