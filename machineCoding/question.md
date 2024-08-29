Logging/Alerting Framework
-----------------------------

1. metric collection - API, Pub/sub
2. Alerting part

Alerting
--------------
1. Some sort of metrics.. P99 / P95 .
2. sort of alerting thresholds -- latencies, 5XX (CRUD, scheduling- Alerting hours, Alerting Engine)
3. notification channels - (opsgenie) 
   1. Alert name
   2. Alert threshold - 
   3. Channels: Slack, email etc
   4. On-calls: On call person


Metric Collector
----------------
Stub -> Metric (inflow) -> stored somewhere

Alert Manager
-----------------

CRUD on alerts(set conditions)
set notification channels

Alert Engine
---------------

Keep running(scheduled)
