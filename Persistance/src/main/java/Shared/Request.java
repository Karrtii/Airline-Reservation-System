package Shared;
import java.io.Serializable;

public class Request implements Serializable
{
  private String type;
  private Object arg;
  private Object arg2;
  private Object arg3;
  private Object arg4;
  private String stringArg;

  public Request(String type, Object arg)
  {
    this.type = type;
    this.arg = arg;
  }

  public Request(String type, Object arg,String stringArg)
  {
    this.type = type;
    this.arg = arg;
    this.stringArg = stringArg;
  }

  public Request(String type,Object arg,Object arg2,Object arg3)
  {
    this.type = type;
    this.arg = arg;
    this.arg2 = arg2;
    this.arg3 = arg3;
  }

  public Request(String type, Object arg, Object arg2, Object arg3, Object arg4)
  {
    this.type = type;
    this.arg = arg;
    this.arg2 = arg2;
    this.arg3 = arg3;
    this.arg4 = arg4;
  }

  public String getStringArg()
  {
    return stringArg;
  }

  public Request()
  {

  }

  public Object getArg4()
  {
    return arg4;
  }

  public Object getArg2()
  {
    return arg2;
  }

  public Object getArg3()
  {
    return arg3;
  }

  public Object getArg()
  {
    return arg;
  }

  public String getType()
  {
    return type;
  }

  @Override public String toString()
  {
    return "Request{" + "type='" + type + '\'' + ", arg=" + arg + '}';
  }
}
