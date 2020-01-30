
# (Done) 테스트 메서드 호출하기
# (Done) 먼저 setUp 호출하기
# () 나중에 tearDown 호출하기
# () 테스트 메서드가 실패하더라도 tearDown 호출하기
# () 여러 개의 테스트 실행하기
# () 수집된 결과를 출력하기

class TestCase:
    def __init__(self, name):
        self.name = name

    def setUp(self):
        pass

    def run(self):
        self.setUp()
        method= getattr(self, self.name)
        method()

class WasRun(TestCase):
    def __init__(self, name):
        TestCase.__init__(self, name)

    def testMethod(self):
        self.wasRun= 1

    def setUp(self):
        self.wasRun = None
        self.wasSetUp= 1

class TestCaseTest(TestCase):
    def setUp(self):
        self.test= WasRun("testMethod")

    def testRunning(self):
        self.test.run()
        assert(self.test.wasRun)

    def testSetUp(self):
        self.test.run()
        assert(self.test.wasSetUp)

TestCaseTest("testRunning").run()

TestCaseTest("testSetUp").run()


