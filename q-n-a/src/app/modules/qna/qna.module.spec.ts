import { QnaModule } from './qna.module';

describe('QnaModule', () => {
  let qnaModule: QnaModule;

  beforeEach(() => {
    qnaModule = new QnaModule();
  });

  it('should create an instance', () => {
    expect(qnaModule).toBeTruthy();
  });
});
