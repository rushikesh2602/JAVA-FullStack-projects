import { TestBed } from '@angular/core/testing';

import { DocauthService } from './docauth.service';

describe('DocauthService', () => {
  let service: DocauthService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DocauthService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
