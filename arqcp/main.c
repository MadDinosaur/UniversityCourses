#include <stdio.h>

int main (void) {
    union u1 {
        long long k;
        char l;
        struct s1 *m;
    };

    struct s2 {
        char *f;
        struct s1 *g;
        struct s2 *h;
        char i;
        union u1 *j[3];
    };

    struct s1 {
        char a;
        struct s2 b;
        long long *c[3];
        union u1 d;
        short e;
    };

    printf("%d\n", sizeof(struct s1));
    
    return 0;
}