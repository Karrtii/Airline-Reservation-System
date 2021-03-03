package Shared;

import java.io.Serializable;

public class Ticket implements Serializable
{
public int price;
public String luggage;
public int seat;

  public Ticket(int price, String luggage)
  {
    this.price = price;
    this.luggage = luggage;
  }

  public Ticket(int price, String luggage, int seat)
  {
    this.price = price;
    this.luggage = luggage;
    this.seat = seat;
  }

  public Ticket()
  {

  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Ticket))
      return false;
    Ticket other = (Ticket) obj;
    return price==other.price&&luggage.equals(other.luggage)&&seat== other.seat;
  }

  @Override public String toString()
  {
    return "Ticket{" + "price=" + price + ", luggage='" + luggage + '\'' + '}';
  }
}
