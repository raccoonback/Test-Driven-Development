
# (Done) 테스트 메서드 호출하기
# (Done) 먼저 setUp 호출하기
# (Done) 나중에 tearDown 호출하기
# () 테스트 메서드가 실패하더라도 tearDown 호출하기
# (Done) 여러 개의 테스트 실행하기
# (Done) 수집된 결과를 출력하기
# (Done) WasRun에 로그 문자열 남기기
# (Done) 실패한 테스트 보고하기
# () setUp 에러를 잡아서 보고하기
# () TestCase 클래스에서 TestSuite 생성하기


class TestCase:
    def __init__(self, name):
        self.name = name

    def setUp(self):
        pass

    def run(self, result):
        result.testStarted()
        self.setUp()
        try:
            method= getattr(self, self.name)
            method()
        except:
            result.testFailed()
        self.tearDown()

    def tearDown(self):
        pass

class TestSuite:
    def __init__(self):
        self.tests= []

    def add(self, test):
        self.tests.append(test)

    def run(self, result):
        for test in self.tests:
            test.run(result)

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
        self.failureCount= 0

    def testStarted(self):
        self.runCount= self.runCount + 1

    def testFailed(self):
        self.failureCount= self.failureCount + 1

    def summary(self):
        return "%d run, %d failed" % (self.runCount, self.failureCount)

class TestCaseTest(TestCase):
    def setUp(self):
        self.result= TestResult()

    def testTemplateMethod(self):
        test= WasRun("testMethod")
        test.run(self.result)
        assert("setUp testMethod tearDown " == test.log)

    def testResult(self):
        test= WasRun("testMethod")
        test.run(self.result)
        assert("1 run, 0 failed" == self.result.summary())

    def testFailedResult(self):
        test= WasRun("testBrokenMethod")
        test.run(self.result)
        assert("1 run, 1 failed" == self.result.summary())

    def testFailedResultFormatting(self):
        self.result.testStarted()
        self.result.testFailed()
        assert("1 run, 1 failed" == self.result.summary())

    def testSuite(self):
        suite= TestSuite()
        suite.add(WasRun("testMethod"))
        suite.add(WasRun("testBrokenMethod"))
        suite.run(self.result)
        assert("2 run, 1 failed" == self.result.summary())


suite= TestSuite()
suite.add(TestCaseTest("testTemplateMethod"))
suite.add(TestCaseTest("testResult"))
suite.add(TestCaseTest("testFailedResult"))
suite.add(TestCaseTest("testFailedResultFormatting"))
suite.add(TestCaseTest("testSuite"))

result= TestResult()
suite.run(result)
print(result.summary())


