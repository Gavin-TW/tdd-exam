# Task

## Store bag

Given : S bag, People ,S Locker has capacity

when : store bag

Then :people  store bag in  S locker and return S ticket

---

Given : S bag, People ,S Locker has no capacity

when : store bag

Then : alert no capacity

---

Given : M bag, People ,M1 Locker has capacity,  M2 Locker has capacity,  primaryLockerRobot

when : store bag

Then :people  store bag in  M1 locker and return M ticket

---

Given : M bag, People ,M1 Locker has no capacity,  M2 Locker has capacity,  primaryLockerRobot

when : store bag

Then :people  store bag in  M2 locker by primaryLockerRobot  and return M  ticket

---

Given : M bag, People ,M1 Locker has no capacity,  M2 Locker has no capacity,  primaryLockerRobot

when : store bag

Then :  alert no capacity

---

Given : L bag, People ,L1 Locker 's  vacancy < L2 Locker 's vacancy,  superLockerRobot

when : store bag

Then : people  store bag in  L2 locker by superLockerRobot and return  L  ticket

---

Given : L bag, People ,L1 Locker has no capacity ， L2 Locker has no capacity,  superLockerRobot

when : store bag

Then : alert no capacity

---

Given : S bag, VIP ,LockerRobotManage, S locker has capacity ,primaryLockerRobot, M locker, superLockerRobot, L locker, 

When: store bag

Then : VIP  store bag in  S locker by LockerRobotManage and return  S  ticket

---

Given : S bag, VIP ,LockerRobotManage, S locker has no capacity ,primaryLockerRobot, M locker, superLockerRobot, L locker, 

When: store bag

Then : alert no capacity

---

Given : M bag, VIP ,LockerRobotManage, S locker ,primaryLockerRobot, M locker  has  capacity, superLockerRobot, L locker, 

When: store bag

Then : VIP  store bag in  M locker by LockerRobotManage and return  M  ticket

---

Given : M bag, VIP ,LockerRobotManage, S locker ,primaryLockerRobot, M locker  has no capacity, superLockerRobot, L locker, 

When: store bag

Then : alert no capacity

---

Given : L bag, VIP ,LockerRobotManage, S locker ,primaryLockerRobot, M locker  , superLockerRobot, L locker has capacity, 

When: store bag

Then : VIP  store bag in  L locker by LockerRobotManage and return  L  ticket

---

Given : L bag, VIP ,LockerRobotManage, S locker ,primaryLockerRobot, M locker  , superLockerRobot, L locker has no capacity, 

When: store bag

Then : alert no capacity

---

Given :  bag, not VIP ,LockerRobotManage, S locker ,primaryLockerRobot, M locker  , superLockerRobot, L locker has no capacity, 

When: store bag

Then : alert no authorization

## get bag

given:   ticket, people 

When : get bag

then : return correct bag

---

given:   ticket, people 

When : get bag,  people make a mistake 

then : alert "wrong type ticket"

---

given:  invalid ticket, people 

When : get bag,

then :  alert "invalid ticket"

---

given:   ticket, VIP 

When : get bag

then :  return correct bag

---

given:  invalid  ticket, VIP 

When : get bag

then :   alert "invalid ticket"

---
