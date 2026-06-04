def solution(n, t, m, timetable):
    # HH:MM 문자열을 전부 계산하기 편하게 분으로 바꾼 뒤 정렬
    crew_time = []
    for time in timetable:
        h, minutes = map(int, time.split(':'))
        crew_time.append(h * 60 + minutes)
    crew_time.sort()
    
    # 첫 버스는 무조건 아침 9시(540분)
    bus_time = 9 * 60
    crew_idx = 0  # 대기열에 선 크루를 가리킬 인덱스
    
    # 버스를 한 대씩 보낸다
    for i in range(n):
        ride_cnt = 0  # 이번 버스에 탄 사람 수
        last_crew_time = 0  # 이번 버스에 마지막으로 탄 크루의 시간
        
        # 버스 자리가 있고, 기다리는 크루가 있고, 그 크루가 버스 시간보다 일찍 왔다면 태움
        while ride_cnt < m and crew_idx < len(crew_time) and crew_time[crew_idx] <= bus_time:
            last_crew_time = crew_time[crew_idx]
            crew_idx += 1
            ride_cnt += 1
            
        # 마지막 버스인 경우 콘의 자리를 결정
        if i == n - 1:
            # 마지막 버스인데 자리가 남았다면 -> 그냥 버스 정시 도착하면 됨
            if ride_cnt < m:
                con_time = bus_time
            # 마지막 버스인데 자리가 꽉 찼다면 -> 마지막으로 탄 놈보다 1분 일찍 와야 됨
            else:
                con_time = last_crew_time - 1
                
        # 다음 버스 시간 갱신
        bus_time += t

    # 분 다시 HH:MM 형식으로 변경
    con_h = str(con_time // 60).zfill(2)
    con_m = str(con_time % 60).zfill(2)
    
    return con_h + ":" + con_m
