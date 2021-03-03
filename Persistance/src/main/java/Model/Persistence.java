package Model;

import Shared.Request;

public interface Persistence
{
  Request handlerRequest(Request request);
}
